package edu.um.coffe.model

class Cafe (_id: String, _nome: String, _rating: Float, _endereco: String, _estado: Boolean, _contacto: Contacto){
    private var id: String
    private var nome: String
    private var rating: Float
    private var endereco: String
    private var estado: Boolean
    private var contacto: Contacto
    private var fotos: MutableList<String>
    private var horarios: MutableList<Horario>

    init {
        id = _id
        nome = _nome
        rating = _rating
        endereco = _endereco
        estado = _estado
        contacto = _contacto
        fotos = mutableListOf()
        horarios = mutableListOf()
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

    fun getContacto(): Contacto {
        return this.contacto
    }

    fun getFotos(): List<String> {
        return this.fotos
    }

    fun getHorarios(): List<Horario> {
        return this.horarios
    }
}