import org.anf.kotlinamex.service.OrderService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderServiceTest {

    @Test
    fun `test empty order`() {
        val request = emptyMap<String,Int>()
        val order = OrderService().createOrder(request)
        assertEquals(0.0, order.cost)
    }

    @Test
    fun `test tiny order`() {
        val request = mapOf("apple" to 1, "orange" to 0)
        val order = OrderService().createOrder(request)
        assertEquals(0.60, order.cost)
    }

    @Test
    fun `test full order`() {
        val request = mapOf("apple" to 10, "orange" to 10)
        val order = OrderService().createOrder(request)
        assertEquals(8.50, order.cost)
    }

    @Test
    fun `test things we do not have `() {
        val request = mapOf("pineapple" to 10, "dragonfruit" to 10)
        val order = OrderService().createOrder(request)
        assertEquals(0.0, order.cost)
    }


    // Need to adjust for this use case...
    @Test
    fun `test negatives`() {
        //etc..
        assertEquals(0, 0)
    }

    @Test
    fun `test offer tiny order`() {
        val request = mapOf("apple" to 1, "orange" to 1)
        val order = OrderService().createOrderWithOffers(request)
        assertEquals(0.85, order.cost)
    }

    @Test
    fun `test offer order`() {
        val request = mapOf("apple" to 2, "orange" to 3)
        val order = OrderService().createOrderWithOffers(request)
        assertEquals(1.1, order.cost)
    }

    @Test
    fun `test random offer order`() {
        val request = mapOf("apple" to 11, "orange" to 11, "dsflkajsdf" to 99)
        val order = OrderService().createOrderWithOffers(request)
        assertEquals(5.60, order.cost)
    }
}