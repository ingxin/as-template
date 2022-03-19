package template.v1.fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API


/**收集fragment的创建信息*/
val FragmentTemplate
    get() = template {
        //模板描述
        name = "MVVM Fragment"
        description = "生成mvvm风格fragment"
        minApi = MIN_API

        //插件位置
        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        val fragmentName = stringParameter {
            name = "Fragment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = {
                fragmentToLayout(fragmentName.value.toLowerCase())
            }
        }

        //点击位置的包名
        val packageName = stringParameter {
            name = "Package name"
            visible = { !isNewModule }
            default = "com.mycompany.myapp"
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

        widgets(
            TextFieldWidget(fragmentName), TextFieldWidget(layoutName)/*, PackageNameWidget(packageName)*/)

        recipe = { data: TemplateData ->
            fragmentRecipe(data as ModuleTemplateData, fragmentName.value, layoutName.value, packageName.value)
        }

    }
