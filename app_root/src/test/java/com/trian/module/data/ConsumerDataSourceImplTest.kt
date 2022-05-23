package com.trian.module.data

import com.trian.data.utils.safeApiCall

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit




class ConsumerDataSourceImplTest {

    private val mockWebServer = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AppApiServices::class.java)



    private val sut = ConsumerDataSourceImpl(api)

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should success login user`() {
        mockWebServer.enqueueResponse("response-login-200.json", 200)

        runBlocking {
            val actual = safeApiCall { sut.loginUser("123","123") }
            val expected = actual
            assertEquals(expected, actual)
        }
    }


    @Test
    fun `should get list article`(){}

    @Test
    fun `should get list doctor`(){}

    @Test
    fun `should send booking doctor`(){}

    @Test
    fun `should get list order`(){}

    @Test
    fun `should detail order`(){}

    @Test
    fun `should get list available doctor time`(){}

    @Test
    fun `should get list speciality`(){}

    @Test
    fun `should get detail room meeting`(){}

    @Test
    fun `should get health status`(){}

    @Test
    fun `should get list hospital`(){}

    @Test
    fun `should get list product`(){}

    @Test
    fun `should get list personal record`(){}

    @Test
    fun `should send measurement`(){}
}