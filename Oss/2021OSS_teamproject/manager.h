//manager.h
#include "product.h"

int selectMenu();
void listProduct(Product *p,int count);
int selectDataNo(Product *p, int count);

void saveData(Product *p, int count);
int loadData(Product *p);

int recommendProduct(Product *p, int count);
int searchLevel();

void analysis(Product *p, int count);
