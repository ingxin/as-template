package template.v1

/**
 * repository模板
 */
fun repositoryKt(appPackage: String?, prefixName: String) = """
package $appPackage.repository

import com.sobey.fc.component.core.app.BaseRepository

class ${prefixName}Repository : BaseRepository() {

}
"""
