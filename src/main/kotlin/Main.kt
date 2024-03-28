import Constants.DEMO_PAYMENT_AMOUNT
import Constants.ONE
import Constants.TEN
import com.huangsam.hello.Hello
import com.huangsam.lambda.IntegerFun
import com.huangsam.payment.PayStrategy
import com.huangsam.payment.PaymentMethod
import com.huangsam.person.Engineer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val logger: Logger = LoggerFactory.getLogger(Constants.MAIN)

fun demoHello() {
    val hello = Hello()
    hello.say()
    hello.yell()
    hello.whisper()
    hello.address("Sam")
    hello.address("Jay")
}

fun demoLambda() {
    // listOf is different from toList - https://stackoverflow.com/q/66335870
    val ints = (ONE..TEN).toList()
    val evenCount = IntegerFun.filteredEvenCount(ints)
    logger.info("The list $ints has $evenCount even numbers")
}

fun demoPayment() {
    val applePay = PayStrategy.createFromMethod(PaymentMethod.APPLE)
    applePay.collectPaymentDetails()
    var successfulPaymentCount = 0
    while (applePay.pay(DEMO_PAYMENT_AMOUNT)) {
        successfulPaymentCount += 1
    }
    logger.info("Paid for lunch $successfulPaymentCount times before having insufficient funds")
    logger.info("Remaining balance: ${applePay.balance()} dollars")
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
    demoLambda()
    demoPayment()
    demoPerson()
}
