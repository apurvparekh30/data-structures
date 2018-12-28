ArrayDeque<Node> ad = new ArrayDeque<>();
        while(true){
            if(root==null && ad.isEmpty())
                break;
            while(root!=null){
                ad.addLast(root);
                root = root.left;
            }
            if(ad.getLast().right == null){
                Node tmp = ad.peekLast();
                System.out.printf("%d ",tmp.data);
                root = null;
            }
            else{
                root = ad.getLast().right;
            }
        }