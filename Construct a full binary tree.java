class Solution{
  public:
    Node* help(int &index,int start,int end,int pre[],int preMirror[],int n){
        if(index>=n or start>end)return NULL;
        if(index==n-1 or start==end){
            Node* temp = new Node(pre[index]);
            index++;
            return temp;
        }
        Node* temp = new Node(pre[index]);
        index++;
        for(int i=start;i<=end;i++){
            if(pre[index]==preMirror[i]){
                temp->left = help(index,i,end,pre,preMirror,n);
                temp->right = help(index,start+1,i-1,pre,preMirror,n);
                break;
            }
        }
        return temp;
    }
    Node* constructBinaryTree(int pre[], int preMirror[], int size)
    {
        // Code here
        int index=0;
        return help(index,0,size-1,pre,preMirror,size);
    }
};
