import com.huangsam.hello.Hello
import com.huangsam.lambda.IntegerFun
import com.huangsam.payment.PayStrategy
import com.huangsam.payment.PaymentMethod
import com.huangsam.person.Engineer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private const val ONE = 1
private const val TEN = 10
private const val DEMO_PAYMENT_AMOUNT = 30

private val logger: Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)

fun demoHello() {
    val hello = Hello()
    hello.say()
    hello.yell()
    hello.whisper()
    hello.address("John Doe")
}

fun demoLambda() {
    // listOf versus toList - https://stackoverflow.com/q/66335870
    val ints = (ONE..TEN).toList()
    val evenCount = IntegerFun.filteredEvenCount(ints)
    logger.info("The list $ints has $evenCount even numbers")
}

fun demoPayment() {
    val applePay = PayStrategy.create(PaymentMethod.APPLE)
    applePay.displayInfo()
    var successfulPaymentCount = 0
    while (applePay.makePayment(DEMO_PAYMENT_AMOUNT)) {
        successfulPaymentCount += 1
    }
    logger.info("Paid for lunch $successfulPaymentCount times before having insufficient funds")
    logger.info("Remaining balance: ${applePay.getBalance()} dollars")
}

fun demoPerson() {
    val engineer = Engineer("Sam")
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
