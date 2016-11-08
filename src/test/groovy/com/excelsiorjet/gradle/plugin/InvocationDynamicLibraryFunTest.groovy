package com.excelsiorjet.gradle.plugin

import org.gradle.testkit.runner.TaskOutcome

class InvocationDynamicLibraryFunTest extends BaseFunTest implements HelloWorldProject {

    def "jetBuild task builds invocation dynamic library"() {
        when:
        def result = runGradle('jetBuild')

        then:
        String dllname = mangleDllName("HelloDll")

        File dllFile = new File(jetBuildDir, dllname)
        dllFile.exists()
        !dllFile.text.contains("<mainClass>")
        File dllFileInApp = new File(appDir, dllname)
        dllFileInApp.exists()

        result.task(":jetBuild").outcome == TaskOutcome.SUCCESS
    }

    public String testProjectDir() {
        return "23-invocation-dynamic-library"
    }

}
