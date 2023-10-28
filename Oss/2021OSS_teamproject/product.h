//product.h
#ifndef PRO
#define PRO

#include <stdio.h>
//#include <stdlib.h>

typedef struct{
    char name[20];//product name
    int level;// 1~7까지의 최대 허용 범주[1:비건, 2:락토, 3:오보, 4:낙토 오보, 5:페스코, 6:폴로, 7:플렉시터리언] 
    int type;//1~6의 숫자로 종류입력[1:채식, 2:우유 및 유제품, 3:달걀, 4:생선, 5:닭, 6:소,돼지]
    int calorie;//100g당 칼로리
    int like;//추천 수

}Product;
#endif

int createProduct(Product *p);
void readProduct(Product *p);
void updateProduct(Product *p);
int deleteProduct(Product *p);


