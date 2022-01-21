package edu.um.coffe.model

class GestCafes {
    //private var bd: DataBaseAccess
    private var cafes: MutableList<Cafe>
    private var currentUser: User

    init {
        cafes = mutableListOf()
        currentUser = User()    //empty constructor
    }

    fun loadCafes(){
        //TODO: this.cafes = bd.getCafes()
    }

    fun login(userName: String, password: String){
        //User u = bd.getUser(userName, password)
        //if(u.password == password) this.currentUser = u
        //else                       throw Exception?

        //verificação aqui ou no DataBaseAccess?
    }

    fun changeUserName(newUserName: String){
        currentUser.setUserName(newUserName)
        //TODO: update base de dados
    }

    fun changePassword(oldPassword: String, newPassword: String){
        //verificação aqui ou no DataBaseAccess?
        //TODO: db.changePassword(oldPassword, newPassword)
    }

    fun addToHistorico(idCafe: String): Boolean{
        if(idCafeExiste(idCafe)) {
            currentUser.addToHistorico(idCafe)
            //TODO: update base de dados
            return true
        }
        else
            return false
    }

    fun addToFavoritos(idCafe: String): Boolean{
        if(idCafeExiste(idCafe)) {
            currentUser.addToFavoritos(idCafe)
            //TODO: update base de dados
            return true
        }
        else
            return false
    }

    private fun idCafeExiste(idCafe: String): Boolean{
        var res = false

        for(cafe in this.cafes) {
            if (cafe.getId() == idCafe) {
                res = true
                break
            }
        }

        return res
    }

    fun changeProfilePicture(foto: String){
        currentUser.setProfilePicture(foto)
        //TODO: update base de dados
    }

    fun createNewUser(userName: String, password: String, email: String): User{
        //FIXME: standard photo
        var newUser: User = User(userName, email, "standard_photo.jpg")
        //TODO: db.addUser(user)
        return newUser
    }
}