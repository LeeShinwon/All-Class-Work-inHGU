//manager.c
#include "product.h"

int selectMenu(){
    int menu;
    printf("\n\n1. 제품조회\n");
    printf("2. 제품추가\n");
    printf("3. 제품수정\n");
    printf("4. 제품삭제\n");
    printf("5. 파일저장\n");
    printf("6. 제품분석\n");//사람들이 가장 선호하는 채식 알려줌
    printf("7. 제품검색\n");//검색한 제품에 대한 정보를 알려줌
    printf("8. 제품추천\n");//선택한 범주에 맞는 제품을 추천해줌
    printf("0. 종료\n");
    printf("=> 원하는 메뉴는? ");
    scanf("%d", &menu);

    return menu;
}

void listProduct(Product *p,int count){

    printf("\nNo. Name           level  type       calorie  like\n");
    printf("========================================================\n");
    for(int i=0; i<count; i++){
        if( p[i].type == -1 || p[i].level == -1 ) continue;
        printf("%2d. ", i+1);
        readProduct(&p[i]);
    }
    printf("\n");
}

int selectDataNo(Product *p, int count){
    int no;
    listProduct(p,count);
    printf("번호는 (취소:0)?");
    scanf("%d",&no);
    getchar();
    return no;
}

void saveData(Product p[], int count){
	FILE* fp;

	fp= fopen("product.txt","wt");
	for(int i=0; i<count; i++){
		if( p[i].type == -1 || p[i].level == -1 ) continue;
		fprintf(fp, "%d %d %d %d %s\n", p[i].level, p[i].type, p[i].calorie, p[i].like, p[i].name);
	}
	
	fclose(fp);
	printf("저장됨!\n");
}

int loadData(Product *p){
	int count=0;
	FILE*fp;
	fp = fopen("product.txt", "rt");
	int i;
	for(i=0; i<100; i++){
		fscanf(fp, "%d", &p[i].level);
		if(feof(fp)) break;
		fscanf(fp, "%d %d %d %s", &p[i].type, &p[i].calorie, &p[i].like, p[i].name);
	}
	fclose(fp);


	printf("=> 로딩 성공!\n");
	return i;
}

int recommendProduct(Product *p, int count){
    char level_list[7][20] = {"Vegan", "Lacto", "Ovo", "Lacto Ovo",  "Pesco", "Pollo","Flexitarian"};
    char type_list[6][20] = {"vegetable", "milk", "egg", "fish", "chicken", "fork, beef"};

    Product cmp;
    int scount=0;

    printf("------------------------------------------------------------------------------\n|");
    for(int i=0; i<7; i++){
        printf("%d: %s", i+1, level_list[i]);
        if(i<6){
            printf(", ");
        }
    }
    printf("|\n------------------------------------------------------------------------------\n");

    printf("허용 범위는? ");
    scanf("%d",&cmp.level);

    printf("-------------------------------------------------------------------\n|");
    for(int i=0; i<6; i++){
        printf("%d: %s", i+1, type_list[i]);
        if(i<5){
            printf(", ");
        }
    }
    printf("|\n-------------------------------------------------------------------\n");

    printf("음식 종류는? ");
    scanf("%d",&cmp.type);

    printf("100g당 최대 칼로리는? ");
    scanf("%d",&cmp.calorie);

    printf("최소 추천수는? ");
    scanf("%d",&cmp.like);

    printf("\n\n<추천 목록>\n");

    for(int i=0; i<count; i++){
        if(p[i].level<=cmp.level){
            if(p[i].type==cmp.type){
                if(p[i].calorie<=cmp.calorie){
                    if(p[i].like>=cmp.like){
                        readProduct(&p[i]);
                        scount++;
                    }
                }
            }
        }
    }
    return scount;
    
}
int searchLevel(){
    char level_list[7][20] = {"Vegan", "Lacto", "Ovo", "Lacto Ovo", "Pesco", "Pollo","Flexitarian"};
    char type_list[7][20] = {"vegetable", "milk", "egg", "fish", "chicken", "fork, beef", "etc"};

    char name[20];
    int type;

    printf("\n");
    printf("제품명은? ");
    scanf("%[^\n]s",name);

    printf("\n\n--------------------------------------------------------------------------\n|");
    for(int i=0; i<7; i++){
        printf("%d: %s", i+1, type_list[i]);
        if(i<6){
            printf(", ");
        }
    }
    printf("|\n--------------------------------------------------------------------------\n");

    printf("음식 종류는? ");
    scanf("%d",&type);

    if(type==7){
        return -1;
    }

    printf("\n\n %s 제품은 ", name);

    for(int i=type; i<7; i++){
        if(type==1){
            if(i==2){
                continue;
            }
        }
        printf("%s", level_list[i]);
        if(!(i+1==7)){
            printf(", ");
        }
    }
    printf(" 까지 섭취할 수 있습니다.\n\n");
    return 0;
}

void analysis(Product *p, int count){
    int calorie_min, calorie_max, calorie_sum = 0;
    int calorie_min_i = 0, calorie_max_i = 0;
    double calorie_avg;
    int like_min, like_max, like_sum = 0;
    int like_min_i = 0, like_max_i = 0;
    double like_avg;

    calorie_min = p[0].calorie;
    calorie_max = p[0].calorie;
    like_min = p[0].like;
    like_max = p[0].like;

    for(int i = 0; i < count; i++){
        if(p[i].calorie > calorie_max){
            calorie_max = p[i].calorie;
            calorie_max_i = i;
        }
        if(p[i].calorie < calorie_min){
            calorie_min = p[i].calorie;
            calorie_min_i = i;
        }
        if(p[i].like > like_max){
            like_max = p[i].like;
            like_max_i = i;
        }
        if(p[i].like < like_min){
            like_min = p[i].like;
            like_min_i = i;
        }
        calorie_sum += p[i].calorie;
        like_sum += p[i].like;
    }
    calorie_avg = calorie_sum*1.0/count*1.0;
    like_avg = like_sum*1.0/count*1.0;
    printf("--------------------------------------------------------");
    printf("\n칼로리가 가장 많은 식품은 %d 칼로리의 %s입니다.\n", calorie_max, p[calorie_max_i].name);
    printf("칼로리가 가장 적은 식품은 %d 칼로리의 %s입니다.\n", calorie_min, p[calorie_min_i].name);
    printf("식품의 평균 칼로리는 %.1f 칼로리입니다.\n", calorie_avg);
    printf("\n추천 수가 가장 많은 식품은 %d 번의 추천을 받은 %s입니다.\n", like_max, p[like_max_i].name);
    printf("추천 수가 가장 적은 식품은 %d 번의 추천을 받은 %s입니다.\n", like_min, p[like_min_i].name);
    printf("식품의 평균 추천 수는 %.1f 입니다.\n", like_avg);
    printf("--------------------------------------------------------\n");
    printf("\n분석이 완료되었습니다.\n");
}