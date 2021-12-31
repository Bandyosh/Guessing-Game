
public class Start {
    public Start(){
   final int livesResp = zForm.Int(ANSI.CYAN(), "How many lives do you want to play with?");
   console.color(ANSI.lightRed(), "The computer will choose a number and it is your objective to guess the same number, Good Luck.");
    if(livesResp <= 0){
        console.error("Invalid Input(s)");
        zForm.Restart();
    }

    for(int x = livesResp; x>=0; x--){
        if(x == 0) {
            console.color(ANSI.RED(), "You failed to guess the right number in: " + livesResp + " lives");
            zForm.Restart();
        } else {
            int mathrandom = (int) (Math.random() * 100);
            int resp = zForm.Int(ANSI.CYAN(), "Guess a number between " + guessLow(mathrandom) + " and " + guessHigh(mathrandom));
            if (mathrandom == resp) {
                console.log("You guessed the right number in: " + livesResp + " lives");
                zForm.Restart();
            } else {
                console.color(ANSI.orange(), "The correct number was: " + mathrandom + "\nLives Remaining: " + (x-1));
            }
        }
    }

    }
    public int guessHigh(int MathRandom){
        int hintRandom = (int) (Math.random() * 10);
        int response = MathRandom + hintRandom;
        if(response > 100){
            response = 100;
        }
        return response;

    }
    public int guessLow(int MathRandom){
        int hintRandom = (int) (Math.random() * 10);
        int response = MathRandom - hintRandom;
        if(response < 0){
            response = 0;
        }
        return response;
    }
}
