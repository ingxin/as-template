package template.v1.fragment


/**
 * fragment模板
 * @param applicationPackage 当前module包名
 * @param prefixName fragment前缀名字，${fragmentPrefix}Fragment则为完整的fragment名字
 * @param viewBindName 布局文件对应的viewBinding
 * @param packageName fragment当前位置的包名
 */
fun fragmentKt(
    applicationPackage: String?, prefixName: String, viewBindName: String, packageName: String
) = """
package $packageName

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import $applicationPackage.databinding.$viewBindName
import $applicationPackage.vm.${prefixName}ViewModel
import com.sobey.fc.component.core.app.BaseFragment

class ${prefixName}Fragment : BaseFragment() {

    private lateinit var mBinding: $viewBindName
    private val mViewModel by lazy { ViewModelProvider(this).get(${prefixName}ViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = ${viewBindName}.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
"""