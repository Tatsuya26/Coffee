package business

class User (_userName: String, _email: String, _profilePicture: String){
    private val userName: String
    private val email: String
    private val profilePicture: String

    init {
        userName = _userName
        email = _email
        profilePicture = _profilePicture
    }

    fun getUserName(): String{
        return this.userName
    }

    fun getEmail(): String{
        return this.email
    }

    fun getProfilePicture(): String{
        return this.profilePicture
    }
}