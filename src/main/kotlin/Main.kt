import com.huangsam.hello.Hello
import com.huangsam.payment.PaymentFactory
import com.huangsam.person.Engineer

fun demoHello() {
    val hello = Hello()
    hello.say()
    hello.yell()
    hello.whisper()
    hello.address("Sam")
}

fun demoPayment() {
    val applePay = PaymentFactory().createFromMethodName("apple", 100)
    applePay.collectPaymentDetails()
    var successfulPaymentCount = 0
    while (applePay.pay(30)) {
        successfulPaymentCount += 1
    }
    println("Paid for lunch $successfulPaymentCount times before having insufficient funds")
    println("Remaining balance: ${applePay.balance()} dollars")
}

fun demoPerson() {
    val engineer = Engineer("Chris")
    engineer.run()
    engineer.walk()
    engineer.eat()
    engineer.sleep()
    engineer.code()
}

fun main() {
    demoHello()

    demoPayment()

    demoPerson()
}
