package evan.chen.tutorial.mvvmdatabindingsample

import android.databinding.ObservableField
import evan.chen.tutorial.mvvmdatabindingsample.api.ProductResponse

class ProductViewModel(private val productRepository: IProductRepository) {

    var productName: ObservableField<String> = ObservableField("")
    var productDesc: ObservableField<String> = ObservableField("")
    var productPrice: ObservableField<Int> = ObservableField(0)
    var productItems: ObservableField<String> = ObservableField("")

    fun getProduct(productId: String) {
        productRepository.getProduct(productId, object : IProductRepository.LoadProductCallback {
            override fun onProductResult(productResponse: ProductResponse) {
                productName.set(productResponse.name)
                productDesc.set(productResponse.desc)
                productPrice.set(productResponse.price)
            }
        })
    }

    fun buy() {
        println("buy")
    }

}


