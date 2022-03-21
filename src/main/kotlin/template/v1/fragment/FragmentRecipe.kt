package template.v1.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import org.jetbrains.kotlin.konan.file.File
import template.v1.layoutXml
import template.v1.viewModelKt
import template.v1.repositoryKt


/**
 * 生成对应文件
 * @param moduleData 所在module的配置
 * @param prefixName 生成文件前缀
 * @param layoutName xml文件名
 */
fun RecipeExecutor.fragmentRecipe(
    moduleData: ModuleTemplateData, prefixName: String, layoutName: String
) {
    val projectData = moduleData.projectTemplateData

    //点击工程module时相关路径
    val srcDir = moduleData.srcDir
    val resDir = moduleData.resDir
    //module根目录
    val rootDir = moduleData.rootDir
    //module的包名
    val appPackage = projectData.applicationPackage
    //点击生成文件时鼠标所在包名
    val clickPackageName = moduleData.packageName

    //获取viewBinding类名
    val names = layoutName.split(Regex("_"))
    val sb = StringBuilder()
    names.forEach {
        val cs = it.toCharArray()
        cs[0] = cs[0] - 32
        sb.append(String(cs))
    }
    sb.append("Binding")

    val appPath =
        "src${File.separator}main${File.separator}java${File.separator}${appPackage?.replace(".", File.separator)}"
    //viewModel文件路径
    val vmFilePath = "$appPath${File.separator}vm${File.separator}${prefixName}ViewModel.kt"
    //repository文件路径
    val repositoryFilePath = "$appPath${File.separator}repository${File.separator}${prefixName}Repository.kt"

    save(layoutXml(), resDir.resolve("layout/${layoutName}.xml"))
    save(viewModelKt(appPackage, prefixName), rootDir.resolve(vmFilePath))
    save(repositoryKt(appPackage, prefixName), rootDir.resolve(repositoryFilePath))
    save(
        fragmentKt(appPackage, prefixName, sb.toString(), clickPackageName), srcDir.resolve("${prefixName}Fragment.kt")
    )
}