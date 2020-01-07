import java.lang.StringBuilder

/**
 * Created by User on 07 Янв., 2020
 */
fun main(args: Array<String>) {
    val commandList = "LIST"
    val commandAdd = "ADD"
    val commandExit = "exit"

    val emailList = EmailList()
    do {
        val inline = readLine()
        if (inline != null) {
            val strings = inline.split("\\s".toRegex())
            if ((strings.size == 1) and (strings.get(0).equals(commandList))) {
                println(emailList.getList())
            } else if (strings.size == 2) {
                if (strings.get(0).equals(commandAdd)) {
                    emailList.add(strings.get(1))
                }
            } else println("Invalid format")
        }

    } while (!inline.equals(commandExit) or (inline == null))
}

class EmailList{
    private var emailSet: HashSet<String> = HashSet()

    fun add(email: String){
        if (checkEmail(email)){
        if (!emailSet.add(email)){
            println("E-mail \"$email\" уже в списке!")
        }}
    }

    fun getList(): String{
        val builder = StringBuilder()
        for (email in emailSet){
            builder.append("$email\n")
        }
        return builder.toString()
    }

    private fun checkEmail(email: String): Boolean{
        if (!email.matches("^.+@.+".toRegex())) {
            println("E-mail \"$email\" не корректен!")
            return false
        }
        return  true
    }
}