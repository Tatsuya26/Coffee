package business

class Cafe (_id: String, _nome: String, _rating: Float, _endereco: String, _estado: Boolean){
    private var id: String
    private var nome: String
    private var rating: Float
    private var endereco: String
    private var estado: Boolean

    init {
        id = _id
        nome = _nome
        rating = _rating
        endereco = _endereco
        estado = _estado
    }

    fun getId(): String{
        return this.id
    }

    fun getNome(): String {
        return this.nome
    }

    fun getRating(): Float {
        return this.rating
    }

    fun getEndereco(): String {
        return this.endereco
    }

    fun getEstado(): Boolean {
        return this.estado
    }

}