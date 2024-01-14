import com.example.test.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", "6d7c11252bmsh9d1bdc83e3cfc9ep190b23jsn0b9a92034ab6")
            .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")// Add your headers here
            .build()
        return chain.proceed(request)
    }
}

val apiInterceptor = ApiInterceptor()

val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(apiInterceptor)
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://api-football-v1.p.rapidapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

val apiService = retrofit.create(ApiService::class.java)
