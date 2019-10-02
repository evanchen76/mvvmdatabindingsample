package evan.chen.tutorial.mvvmdatabindingsample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import evan.chen.tutorial.mvvmdatabindingsample.api.ProductAPI
import evan.chen.tutorial.mvvmdatabindingsample.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {

    private val productId = "pixel3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val dataBinding = DataBindingUtil.setContentView<ActivityProductBinding>(this, R.layout.activity_product)

        val productAPI = ProductAPI()
        val productRepository = ProductRepository(productAPI)

        val productViewModel = ProductViewModel(productRepository)

        dataBinding.productViewModel = productViewModel

        //加這一段就可以讓model有變就更新回UI
        dataBinding.lifecycleOwner = this

        productViewModel.getProduct(productId)
    }

}
