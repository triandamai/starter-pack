package com.trian.module.utility

import com.trian.domain.utils.analytics.EarlyWarningScore
import org.junit.Assert.assertEquals
import org.junit.Test

class EwsResponseTest {
    @Test
    fun `get Danger EWS`(){
        val ews = EarlyWarningScore(
            7,//should 3
            70,//should 3
            20f,//should 3
            91,//should 3

            20,//should 3
            false,
            false)
        assertEquals(3,ews.getResult().level)
    }

    @Test
    fun `get respiration normal other danger EWS`(){
        val ews = EarlyWarningScore(
            19,//should normal
            70,//should 3
            20f,//should 3
            91,//should 3

            20,//should 3
            false,
            false)
        assertEquals(3,ews.getResult().level)
    }


    @Test
    fun `get respiration danger other normal EWS`(){
        val ews = EarlyWarningScore(
            7,//should 3
            112,
            37f,
            95,
            52,
            false,
            false)
        assertEquals(2,ews.getResult().level)
    }

}


