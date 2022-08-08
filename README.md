# **Chess 2**
<h3>What is "Chess 2"?</h3>

"Chess 2" is a heavily modified version of chess, invented by YouTuber<a href="https://www.youtube.com/c/OatsJenkins"> Oats Jenkins</a>.
The concept (and rules of the game) are explained in <a href="https://youtu.be/mcivL8u176Y"> this video</a> (or read below). *I made this game mainly for recreational 
purposes; I am not owner of this idea.*


<h3>What are the rules of "Chess 2"?</h3>

The layout of "Chess 2" is as follows: 

![image](https://user-images.githubusercontent.com/97300523/178115695-d8b7a778-4de9-4620-b762-656bd6b673e8.png)

Let's start with the figure at position A1, the **crow**. The crow, unlike the rook, can move *anywhere* in the playing field, but it's "attacking range" is limited to 
one space in the main axis (up/down/left/right, x/y - axis). It cannot attack in the diagonals. Furthermore, it can *only* attack if at least one of the allied pieces 
has been defeated in the previous round.

The next figure to the right (on position B1) is the **monkey**. It's movement is reminiscent of <a href="https://en.wikipedia.org/wiki/Chinese_checkers"> Chinese chequers</a> (or _Sternhalma_),
being able to junp over other pieces from any direction and landing on the other side (this can be done multiple times in a round, if conditions are met). 
Furthermore, it can also move one space into any direction (main and diagonal axis), albeit it cannot defeat another piece when moving like so.
_The monkey also serves a different, rather important purpose, which will be explained later on._

Example on how a monkey could move:

![image](https://user-images.githubusercontent.com/97300523/178116419-f95c0ab1-0537-47c7-9889-c88f97ea0ab4.png)


The next piece we'll take a look at is the **elephant** in position C2. The elephant moves like the chess equivalent (bishop), although it can only move _two_ spaces into 
the diagonals (exactly two; it cannot move one or three spaces). It's starting position is also not in the back row!

Below and to the sides of the elephant are the **fishies**. Fishies move and attack the same way as a pawn would (it cannot move two spaces at the start, though).
Also like a pawn, it can be _promoted_ when reaching the other side. In doing so, the fishie will turn into a **fishie queen**, which moves like a queen in chess.
Note that a fishie queen is not equal to an actual queen!

The **king** and **queen** move the same way as the chess equivalents.

One might have noticed why the king has a banana on his head; this is due to the fact that when the king has been beaten, the game doesn't end _immediately_. Instead,
the king lands in **jail**, which is located th the left and right of the board for each player respectively. The game can only be finished if one manages to capture the
_king and queen_ (i.e. when both are in jail). But here, the banana comes into play: The **monkey** can "free" the king _once_ by grabbing the king and dropping him next to jail.
In order to achieve this, a certain constellation has to be achieved. For example: 

![image](https://user-images.githubusercontent.com/97300523/178117151-1f62242d-751a-4972-b80e-546dc02ab55d.png)

By doing so, the banana on the king will dissapear.

Let's go to our final piece on the board, the **bear**. The bear starts in the middle of the board, although not being on any field. He does not belong to any player.
Any player can move him around; he can move one field into all directions (diagonals included).
He cannot attack anyone, but he can be killed. If killed, the bear cannot return to the board.

<h3>On what language is this game programmed?</h3>

Java, with the usage of the libary <a href=https://github.com/Krassnig/CodeDraw>_CodeDraw_</a>. Note that an older version of _CodeDraw_ is used here (never versions 
of _CodeDraw_ have issues regarding reading `.png` files).

**This game is still work in progress!!!**

