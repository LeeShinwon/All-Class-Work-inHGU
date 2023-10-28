import 'package:midterm/model/product.dart';

class ProductsRepository{
  static List<Product> loadProducts(Category category){
    const allProducts = [
      Product(
          category: Category.USA,
          id: 0,
          name: 'The Plaza, New York',
          location: '768 5th Ave, New York, NY 10019 미국',
        star: 3,
        phone:'+82 010 1234 5678',
        description: 'The Plaza, New York offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',


      ),
      Product(
        category: Category.Erope,
        id: 1,
        name: 'Hotel Ritz Paris',
        location: '15 Pl. Vendôme, 75001 Paris, 프랑스',
        star: 1,
          phone:'+82 010 1234 2345',
        description: 'Hotel Ritz Paris offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
      Product(
        category: Category.Erope,
        id: 2,
        name: 'Claridge’s, London',
        location: 'Brook Street, London W1K 4HR 영국',
        star: 3,
          phone:'+82 010 1435 5678',
        description: 'Claridge’s, London offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
      Product(
        category: Category.Asia,
        id: 3,
        name: 'Raffles, Singapore',
        location: '1 Beach Rd, 싱가포르 189673',
        star: 4,
          phone:'+82 010 1344 5345',
        description: 'Raffles, Singapore offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
      Product(
        category: Category.Asia,
        id: 4,
        name: 'Taj Mahal Palace, India',
        location: 'Apollo Bandar, Colaba, Mumbai, 뭄바이 Maharashtra 400001 인도',
        star: 2,
          phone:'+82 010 13454 5654',
        description: 'Taj Mahal Palace, India offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
      Product(
        category: Category.USA,
        id: 5,
        name: 'Beverly Hills Hotel, Los Angeles',
        location: '9641 Sunset Blvd, Beverly Hills, CA 90210 미국',
        star: 3,
          phone:'+82 010 1564 5645',
        description: 'Beverly Hills Hotel, Los Angeles offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
      Product(
        category: Category.Asia,
        id: 6,
        name: 'Peninsula Hong Kong',
        location: 'Salisbury Rd, Tsim Sha Tsui, 홍콩',
        star: 3,
          phone:'+82 010 1345 6548',
        description: 'Peninsula Hong Kong offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
      Product(
        category: Category.Erope,
        id: 7,
        name: 'The Shelbourne Hotel, Dublin',
        location: ' 27 St Stephen\'s Green, Dublin, 아일랜드',
        star: 3,
          phone:'+82 010 1434 5665',
        description: 'The Shelbourne Hotel, Dublin offers all the facilities you would expect from a 3 star hotel in Krakow: restaurant, room service, bar, front desk open 24 hours, laundry, TV. Located in the south east of Krakow, on Basztowa 25, 6 minutes by car from the hotel. Polonia Hotel Room is ALL DOUBLE',

      ),
    ];
    if(category == Category.all){//0이면
      return allProducts;
    }
    else{
      return allProducts.where(
          (Product p){
            return p.category == category;
          }).toList();
    }
  }
}