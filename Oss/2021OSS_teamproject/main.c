#include <stdio.h>
#include <stdlib.h>
#include "manager.h"

int main(){
    Product slist[100];
    int curcount=0;
    int count = 0, menu;
    
    count = loadData(slist);
    curcount = count; 


    while (1){
        menu = selectMenu();
        getchar();
        if(menu == 0) break;
        if(menu == 1 || menu ==3 || menu == 4 || menu == 6){	
		    if (count==0){ 
                printf(" 데이터가 없습니다!\n");
			    continue;
			}
		}

        if(menu == 1) listProduct(slist,curcount); 
        else if (menu == 2) {
            count+=createProduct(&slist[curcount++]); 
        }
        else if (menu == 3) {
            int no=selectDataNo(slist, curcount);
            if(no==0){
                printf("=>취소됨!");
                continue;
            }
            updateProduct(&slist[no-1]);
        }
        else if (menu == 4) {
            int no=selectDataNo(slist, curcount);
            if(no==0){
                printf("=>취소됨!");
                continue;
            }
            int deleteok;
            printf("정말로 삭제하시겠습니까?(삭제:1)");
            scanf("%d",&deleteok);
            if(deleteok == 1){
                if(deleteProduct(&slist[no-1])) count --;       
           	 } 
        }
	    else if (menu == 5){
		    if (count==0) printf("데이터가 없습니다!\n");
		    else saveData(slist,curcount);
	    }
        else if(menu==6){//제품 분석
            analysis(slist,curcount);
        }
        else if(menu==7){//제품검색
            if(searchLevel()==-1){
                printf("데이터가 없습니다!\n");
            }
        }
        else if(menu==8){//제품추천
            if(recommendProduct(slist, curcount)==0){
                printf("데이터가 없습니다!\n");
            }
        }
	}

	printf("\n종료됨!\n");
   	return 0;
}