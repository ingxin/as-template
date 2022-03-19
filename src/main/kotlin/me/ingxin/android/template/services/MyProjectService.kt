package me.ingxin.android.template.services

import com.intellij.openapi.project.Project
import me.ingxin.android.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
