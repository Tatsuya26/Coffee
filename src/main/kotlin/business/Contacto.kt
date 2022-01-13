package business

class Contacto (_telefone: String, _email: String) {
    private var telefone: String
    private var email: String

    init {
        telefone = _telefone
        email = _email
    }

    fun getTelefone(): String{
        return this.telefone
    }

    fun getEmail(): String{
        return this.email
    }

    fun setTelefone(telefone: String){
        this.telefone = telefone
    }

    fun setEmail(email: String){
        this.email = email
    }
}