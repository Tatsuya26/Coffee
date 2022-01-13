package business

import java.time.LocalDateTime

class CafeListEntry (_cafeId: String, _dataRegisto: LocalDateTime){
    private var cafeId: String
    private var dataRegisto: LocalDateTime

    init{
        cafeId = _cafeId
        dataRegisto = _dataRegisto
    }

    fun getCafeId(): String{
        return this.cafeId
    }

    fun getDataRegisto(): LocalDateTime{
        return this.dataRegisto
    }
}