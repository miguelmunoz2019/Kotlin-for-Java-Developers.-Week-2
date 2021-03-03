package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    var cuenta = 0
    while(cuenta < secret.length){
        if (secret[cuenta]==guess[cuenta])
        {
        rightPosition+=1
        }
        else {
                for( j in  guess.indices){
                    if (secret[cuenta]==guess[j] )
                    {
                        var repetidos=0
                        var repetidos2=0
                        if (guess[j]!=secret[j])
                        {
                            for( h in  0 .. cuenta)
                            {
                                if (secret[h]==secret[cuenta])
                                {
                                repetidos+=1
                                }
                            }
                            for (p in  guess.indices)
                            {
                                if (guess[p]==secret[cuenta])
                                {
                                    repetidos2+=1
                                }
                            }
                            if (repetidos2>=repetidos)
                            {
                                wrongPosition+=1
                                break
                            }

                        }

                    }
                }
             }
        cuenta+=1
    }
    return Evaluation(rightPosition,wrongPosition)
}

