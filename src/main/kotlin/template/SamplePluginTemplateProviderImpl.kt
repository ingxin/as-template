package template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import template.v1.fragment.FragmentTemplate

/**
 * 模板插件入口.
 *
 * @author ingxin
 * @since 2022/3/19
 */
class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(FragmentTemplate)
}