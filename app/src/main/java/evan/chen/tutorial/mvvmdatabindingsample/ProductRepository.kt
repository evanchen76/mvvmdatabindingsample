package evan.chen.tutorial.mvvmdatabindingsample

import evan.chen.tutorial.mvvmdatabindingsample.api.IProductAPI
import evan.chen.tutorial.mvvmdatabindingsample.api.ProductResponse

interface IProductRepository {
    fun getProduct(productId: String, loadProductCallback: LoadProductCallback)

    fun buy(id: String, items: Int, callback: BuyProductCallback)

    interface LoadProductCallback {

        fun onProductResult(productResponse: ProductResponse)
    }

    interface BuyProductCallback {

        fun onBuyResult(isSuccess: Boolean)
    }

}

class ProductRepository(private val productAPI: IProductAPI) : IProductRepository {

    override fun buy(id: String, items: Int, callback: IProductRepository.BuyProductCallback) {
        //模擬購買成功
        callback.onBuyResult(true)
    }

    override fun getProduct(productId: String, loadProductCallback: IProductRepository.LoadProductCallback) {

        productAPI.getProduct(productId, object : IProductAPI.LoadAPICallBack {
            override fun onGetResult(productResponse: ProductResponse) {
                loadProductCallback.onProductResult(productResponse)
            }
        })
    }
}

