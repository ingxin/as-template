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
            name = "FragmentName（只输入名字，不要含Fragment后缀）"
            default = "Main"
            help = "只输入名字，不要Fragment后缀"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val resourcePrefix = stringParameter {
            name = "resourcePrefix（资源文件前缀）"
            default = "app"
            help = "输入资源文件前缀"
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "LayoutName"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = {
//                val sb = StringBuilder()
//                for ((index, chr) in fragmentName.value.withIndex()) {
//                    if (chr.isUpperCase() && index != 0) {
//                        sb.append("_")
//                    }
//                    sb.append(chr.toLowerCase())
//                }
                "${resourcePrefix.value}_fg_${camelCaseToUnderlines(fragmentName.value)}"
            }
        }

        widgets(TextFieldWidget(fragmentName), TextFieldWidget(resourcePrefix), TextFieldWidget(layoutName))

        recipe = { data: TemplateData ->
            fragmentRecipe(data as ModuleTemplateData, fragmentName.value, layoutName.value)
        }

    }
