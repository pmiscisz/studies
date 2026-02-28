
public class PlatformGame {

    Level level;
    GameMap gameMap;
    ArrayList<Platform> platforms;
    Player player;
    ArrayList<Oponents> oponents;
    ArrayList<Treasure> treasures;
    double score;
    String playerName;
    Image avatar;

    public class character{
        public static void up();
        public static void down();
        public static void forward();
        public static void backward();
    }

    public class levels{
        public static void nextlevel();
    }

    public class FirstLevel extends levels{

    }

    public class SecondLevel extends levels{

    }

    public class ThirdLevel extends levels{

    }


    public class GreenSoldier extends character{
    
    }
    public class BlackSoldier extends character{
    
    }
    public class Alien extends character{

    }
    PlatformGame(String playerName) {
        level = new FirstLevel(„Level for begginers”);
        gameMap = new EuropeMap(
        “Green background”);
        player = new GreenSoldier(
                “US Army”);
        for (int i = 0; i < 200; i++) {
                    platforms.add(new GroundPlatform(Colour.BROWN));
                }
                for (int i = 0; i < 100; i++) {
                    oponents.add(new BlackSoldier(“Aliens”));
        }
        for (int i = 0; i < 10; i++) {
                    treasures.add(new Diamond(100));
                }
                score = 0;
                this.playerName = playerName;
                avatar = new Avatar(this.playerName);
            }

            public void changeLevel() {
                if (level instanceof levels) {
                    level.nextlevel;
        }
        }
public void movePlayer(int direction) {
        switch (direction) {
            case 1:
                if (player instanceof [character]) {
                    ((character) player).up();
                }
                break;
            case 2:
                if (player instanceof character) {
                    ((character) player).down();
                }
                break;
            case 3:
                if (player instanceof character) {
                    ((character) player).forward();
                }
                break;
            case 4:
                if (player instanceof character) {
                    ((GreenSoldier) player).backward();
                }
                break;
            default;
                player.stop();
        }

    }
