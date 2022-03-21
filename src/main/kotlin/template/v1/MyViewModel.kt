package template.v1

/**
 * viewModel模板
 */
fun viewModelKt(appPackage: String?, prefixName: String) = """
package $appPackage.vm

import android.app.Application
import com.sobey.fc.component.core.app.BaseViewModel

class ${prefixName}ViewModel(application: Application) : BaseViewModel(application) {

}
"""
