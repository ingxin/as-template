package template.v1.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import template.v1.layoutXml
import template.v1.viewModelKt
import template.v1.repositoryKt


/**生成对应的文件*/
fun RecipeExecutor.fragmentRecipe(
    moduleData: ModuleTemplateData, prefixName: String, layoutName: String, packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val appPackage = projectData.applicationPackage

    val names = layoutName.split(Regex("_"))
    val sb = StringBuilder()
    names.forEach {
        val cs = it.toCharArray()
        cs[0] = cs[0] - 32
        sb.append(cs.toString())
    }

    val pPath = appPackage?.replace(".","/")

    save(layoutXml(), resOut.resolve("layout/${layoutName}.xml"))
    save(viewModelKt(appPackage, prefixName), srcOut.resolve("${pPath}/vm/${prefixName}ViewModel.kt"))
    save(repositoryKt(appPackage, prefixName), srcOut.resolve("${pPath}/repository/${prefixName}Repository.kt"))
    save(fragmentKt(appPackage, prefixName, sb.toString(), packageName), srcOut.resolve("${prefixName}Fragment.kt"))
}