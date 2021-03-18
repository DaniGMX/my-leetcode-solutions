package GenerateRandomPointInACircle
import kotlin.random.Random

class Solution(val radius: Double, val x_center: Double, val y_center: Double) {
    
    fun randPoint(): DoubleArray {
        val a = Random.nextDouble(Math.PI * 2.0)
        val l = radius * Math.sqrt(Random.nextDouble())
        return doubleArrayOf(
            (l * Math.cos(a)) + x_center,
            (l * Math.sin(a)) + y_center
        )
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(radius, x_center, y_center)
 * var param_1 = obj.randPoint()
 */