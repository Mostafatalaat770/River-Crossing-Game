// Move Strategy Test//
//put in Move class//

public static void main(String[] args){
        List<ICrosser> left = new ArrayList<>();
        List<ICrosser> right = new ArrayList<>();
        List<ICrosser> boat = new ArrayList<>();
        left.add(new Farmer(10,5));
        left.add(new Lion(10,5));
        left.add(new Rabbit(10,5));
        left.add(new Cabbage());
        boat.add(left.get(0));
        boat.add(left.get(2));
        Move move = new Move(new MoveLeftToRight());
        move.doMove(right,left,boat);
        System.out.println("MUSTY");
        boat.add(right.get(0));
        boat.add(right.get(1));
        move = new Move(new MoveRightToLeft());
        move.doMove(right,left,boat);
        System.out.println("MUSTY");


    }
