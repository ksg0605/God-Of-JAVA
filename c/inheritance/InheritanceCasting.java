package c.inheritance;

public class InheritanceCasting {
    public static void main(String[] args) {
        InheritanceCasting inheritanceCasting = new InheritanceCasting();
//    inheritanceCasting.objectCast();
//    inheritanceCasting.objectCast2();
        inheritanceCasting.objectCastArray();
    }

    public void objectCastArray() {
        ParentCasting[] parentArray = new ParentCasting[3];
        parentArray[0] = new ChildCasting();
        parentArray[1] = new ParentCasting();
        parentArray[2] = new ChildCasting();
        objectTypeCheck(parentArray);
//        ChildCasting childCasting = new ChildCasting();
//
//        ParentCasting parentCasting2 = childCasting;
//        ChildCasting childCasting2 = (ChildCasting)parentCasting;
    }

    public void objectCast2() {
        ChildCasting childCasting = new ChildCasting();
        ParentCasting parentCasting = childCasting;
        ChildCasting childCasting2 = (ChildCasting)parentCasting;
    }

    private void objectTypeCheck(ParentCasting[] parentArray) {
        for(ParentCasting tempParent : parentArray) {
            if(tempParent instanceof ChildCasting) {
                System.out.println("ChildCasting");
            }
            else if(tempParent instanceof ParentCasting) {
                System.out.println("ParentCasting");
            }
        }
    }
}