class MovieRentingSystem {
    HashMap<Integer,TreeSet<Pair>> unrented;
    TreeSet<Group> rentedGroup;
    HashMap<Integer,TreeSet<Pair>> rented;
    HashMap<List<Integer>,Integer> helper;
    public class Pair implements Comparable<Pair>{
        int price;
        int shop;
        Pair(int price,int shop){
            this.price=price;
            this.shop=shop;
        }

        @Override
        public int compareTo(Pair o){
            return Integer.compare(this.price,o.price)==0?Integer.compare(this.shop,o.shop):Integer.compare(this.price,o.price);
        }

        @Override
        public boolean equals(Object o){
            if(o==this) return true;
            if(o==null||getClass()!=o.getClass()) return false;
            Pair p=(Pair)o;
            return p.price==price&&p.shop==shop;
        }

        @Override
        public int hashCode(){
            return Objects.hash(price,shop);
        }
    }

    public class Group implements Comparable<Group>{
        int price;
        int shop;
        int movie;
        Group(int price,int shop,int movie){
            this.price=price;
            this.shop=shop;
            this.movie=movie;
        }

        @Override
        public int compareTo(Group o){
            return Integer.compare(this.price,o.price)==0?(Integer.compare(this.shop,o.shop)==0?Integer.compare(this.movie,o.movie):Integer.compare(this.shop,o.shop)):Integer.compare(this.price,o.price);
        }

        @Override
        public boolean equals(Object o){
            if(o==this) return true;
            if(o==null||getClass()!=o.getClass()) return false;
            Group p=(Group)o;
            return p.price==price&&p.shop==shop&&p.movie==movie;
        }

        @Override
        public int hashCode(){
            return Objects.hash(price,shop,movie);
        }

        
    }


    public MovieRentingSystem(int n, int[][] entries) {
        unrented=new HashMap<>();
        rentedGroup=new TreeSet<>();
        helper=new HashMap<>();
        for(int i=0;i<entries.length;i++){
            TreeSet<Pair> s;
            List<Integer> l=new ArrayList<>();
            l.add(entries[i][0]);
            l.add(entries[i][1]);
            if(unrented.containsKey(entries[i][1])){
                s=unrented.get(entries[i][1]);
                
            }
            else{
                s=new TreeSet<>();
            }

            s.add(new Pair(entries[i][2],entries[i][0]));
            unrented.put(entries[i][1],s);
            helper.put(l,entries[i][2]);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans=new ArrayList<>();
        if (!unrented.containsKey(movie)) return new ArrayList<>();

        TreeSet<Pair> s=unrented.get(movie);
        int count=0;
        for(Pair p:s){
            count++;
            ans.add(p.shop);
            if(count==5){
                break;
            }
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        TreeSet<Pair> s=unrented.get(movie);
        List<Integer> l=new ArrayList<>();
        l.add(shop);
        l.add(movie);
        int p=helper.get(l);
        s.remove(new Pair(p,shop));
        unrented.put(movie,s);
        rentedGroup.add(new Group(p,shop,movie));
    }
    
    public void drop(int shop, int movie) {
        List<Integer> l=new ArrayList<>();
        l.add(shop);
        l.add(movie);
        int p=helper.get(l);
        Group g=new Group(p,shop,movie);
        rentedGroup.remove(g);
        TreeSet s;
        if(unrented.containsKey(movie)){
            s=unrented.get(movie);
        }
        else{
            s=new TreeSet<>();
        }
        s.add(new Pair(g.price,g.shop));
        unrented.put(g.movie,s);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result=new ArrayList<>();
        int count=0;
        for(Group g:rentedGroup){
            count++;
            List<Integer> l=new ArrayList<>();
            l.add(g.shop);
            l.add(g.movie);
            result.add(l);
            if(count==5){
                break;
            }
        }
        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */