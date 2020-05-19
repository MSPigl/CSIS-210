/**
 * @author Matthew Pigliavento 
 * @version November 30, 2016
 */
public class LottoRecursivo
{
    /**
     * Recursively takes the combination of N-take-K (made static for ease of user experience)
     * 
     * @param N the possible numbers
     * @param K the desired cardinality of subsets of N
     * @return C(N-1, K-1) + C(N-1, K) - the number of combinations
     */
    public static int C(int N, int K)
    {
        // base case
        if (N == K || K == 0)
        {
            return 1;
        }
        // inductive step
        return C(N-1, K-1) + C(N-1, K);
    }
}