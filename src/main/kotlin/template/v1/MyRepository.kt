package template.v1

/**
 * repository模板
 */
fun repositoryKt(applicationPackage: String?, prefixName: String) = """
package $applicationPackage.repository

import com.sobey.fc.component.core.app.BaseRepository

class ${prefixName}Repository : BaseRepository() {

}
"""
