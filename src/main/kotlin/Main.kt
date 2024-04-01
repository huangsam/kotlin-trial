import com.huangsam.hello.Hello
import com.huangsam.lambda.IntegerFun
import com.huangsam.payment.PayStrategy
import com.huangsam.payment.PaymentMethod
import com.huangsam.person.Engineer
import com.huangsam.person.isIntern
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private const val ONE = 1
private const val TEN = 10
private const val AGE_OF_ADULTHOOD = 25
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
    var paymentCount = 0
    while (applePay.makePayment(DEMO_PAYMENT_AMOUNT)) {
        paymentCount += 1
    }
    logger.info("Made $paymentCount payments until balance was low")
    logger.info("Remaining balance: ${applePay.getBalance()} dollars")
}

fun demoPerson() {
    val engineer =
        Engineer(
            "Sam",
            AGE_OF_ADULTHOOD,
            certifications = listOf("AWS on Udemy", "GCP on Coursera"),
            qualifications = listOf("UC Davis"),
        )
    logger.info("Is ${engineer.name} able to vote? ${engineer.isReadyToVote()}")
    logger.info("Is ${engineer.name} certified? ${engineer.isTrusted()}")
    logger.info("Is ${engineer.name} an intern? ${engineer.isIntern()}")
    engineer.run()
    engineer.walk()
    engineer.eat()
    engineer.sleep()
    engineer.work()
}

fun main() {
    demoHello()
    demoLambda()
    demoPayment()
    demoPerson()
}
