#include "iostream"
using namespace std;

class Node{
    public:
        int data;
        Node* next;

    //constructor
    Node(int data){
        this -> data = data;
        this -> next = NULL;
    }  


};

void insertAtEnd(Node* &head, Node* &end, int d){

    //handling the case if there is no element in Linked List
    if(head == NULL){
        Node* new_node = new Node(d);
        head = new_node;
        end = new_node;
    }
    else{
        Node* new_node = new Node(d);   
        end -> next = new_node;         
        end = new_node;               
    }
}

//recursive approach
Node* reverse2(Node* &head){
    if(head == NULL || head -> next == NULL){
        return head;
    }

    Node* result = reverse2(head -> next);
    head -> next -> next = head;
    head -> next = NULL;

    return result;

    /*
        Time Complexity = O(n)
        Space Complexity = O(n)
    */
}

//iterative approach
Node* reverse(Node* &head){
    Node* prev = NULL;
    Node* curr = head;
    Node* forw = curr -> next;
//    Node* forw=NULL;

    while(forw != NULL){
        // forw=curr->next;
        curr -> next = prev;
        prev = curr;
        curr = forw;
        forw = forw -> next;
    }
    curr -> next = prev;
    return curr;

    // return head;
    /*
        Time Complexity = O(n)
        Space Complexity = O(1)
    */
}

void display(Node* &head){
    Node* ptr = head;
    while(ptr != NULL){
        cout<<ptr -> data<<" ";
        ptr = ptr -> next;
    }
    cout<<endl;
}

int main(){

    // Node* new_node = new Node(10);
    Node* head = NULL;
    Node* end = NULL;

    insertAtEnd(head, end, 12);
    insertAtEnd(head, end, 13);
    insertAtEnd(head, end, 14);
    insertAtEnd(head, end, 15);
    insertAtEnd(head, end, 16);

    display(head);

    Node* ans = reverse2(head);

    display(ans);


    return 0;
}