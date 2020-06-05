# car-factory

####自動產生車牌系統

1. 定義Car 物件 
    
    屬性 車牌號碼 ,尺寸(長寬)
    
2. 建立車輛類型 (VehicleType)的Enum ,並定義大小車兩種車類型

3  實作大小車兩個class 車輛尺寸亂數產生
   a. 小車：長度100~110 寬度 70~90
   b. 大車：長度115~130 寬度 100~110
   
4. 建立CarFactory中的method, 並印出車輛創建資訊
    Car produceCar(VehicleType vehicleType)
  
5. 建立車牌工廠 PlateNumberFactory 須包含
   static List<String> generatePlateNumber(int countOfPlateNumber)
   countOfPlateNumber 為車牌數量 隨機產生大小車牌號碼
   
   a.大車: length為6 ,數字不重複 e.g HR-256
   
   b.小車: length為8 ,數字可重複 但不得有4 英文字不能重複 e.g SHR-2506
   
   c.車牌號碼不能重複, 重複時 先反轉號碼 e.g HR-244 -> 244-HR
     如果反轉後仍存在 則捨棄
     
   d. 所有號碼產生完畢後捨棄含66的車簰號碼
   
6.用junit test 驗證功能正常

7.用 main 執行
    a. 透過PlateNumberFacrtory產生400個車牌
    b. 開啟2個 thread 產生大車100台 小車100台 並取得車牌掛載到車輛
    c. 如果無法取得車牌, 鷹拋出異常提示
    d. 統計車輛與車牌使用狀況