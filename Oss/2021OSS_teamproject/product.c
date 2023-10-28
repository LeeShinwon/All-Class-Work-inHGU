#include "product.h"
char level_list[7][20] = {"Vegan", "Lacto", "Ovo", "Lacto Ovo",  "Pesco", "Pollo","Flexitarian"};
char type_list[6][20] = {"vegetable", "milk", "egg", "fish", "chicken", "fork, beef"};

int createProduct(Product *p){
    printf("\n");
    printf("제품명은? ");
    scanf("%[^\n]s",p->name);

    printf("------------------------------------------------------------------------------\n|");
    for(int i=0; i<7; i++){
        printf("%d: %s", i+1, level_list[i]);
        if(i<6){
            printf(", ");
        }
    }
    printf("|\n------------------------------------------------------------------------------\n");

    printf("허용 범위는? ");
    scanf("%d",&p->level);

    printf("-------------------------------------------------------------------\n|");
    for(int i=0; i<6; i++){
        printf("%d: %s", i+1, type_list[i]);
        if(i<5){
            printf(", ");
        }
    }
    printf("|\n-------------------------------------------------------------------\n");

    printf("음식 종류는? ");
    scanf("%d",&p->type);

    printf("100g당 칼로리는? ");
    scanf("%d",&p->calorie);

    printf("추천수는? ");
    scanf("%d",&p->like);
    
    printf("==> 추가됨\n"); 
    return 1;
}

void readProduct(Product *p){
    printf("%-15s%-7s%-11s%-9d%d", p->name, level_list[p->level -1], type_list[p->type -1], p->calorie, p->like);
    printf("\n");
}

void updateProduct(Product *p){

    printf("\n");
    printf("\n");
    printf("제품명은? ");
    scanf("%[^\n]s",p->name);

    printf("------------------------------------------------------------------------------\n|");
    for(int i=0; i<7; i++){
        printf("%d: %s", i+1, level_list[i]);
        if(i<6){
            printf(", ");
        }
    }
    printf("|\n------------------------------------------------------------------------------\n");

    printf("허용 범위는? ");
    scanf("%d",&p->level);

    printf("-------------------------------------------------------------------\n|");
    for(int i=0; i<6; i++){
        printf("%d: %s", i+1, type_list[i]);
        if(i<5){
            printf(", ");
        }
    }
    printf("|\n-------------------------------------------------------------------\n");

    printf("음식 종류는? ");
    scanf("%d",&p->type);

    printf("100g당 칼로리는? ");
    scanf("%d",&p->calorie);

    printf("추천수는? ");
    scanf("%d",&p->like);

    printf("==> 수정됨!\n");
};

int deleteProduct(Product *p){
    p->type  = -1;
    p->level = -1;
    printf("==> 삭제됨!\n");
    return 0;
}
