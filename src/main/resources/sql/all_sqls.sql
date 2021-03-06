在此统一管理所有 sql，优点有：
1：避免在 JFinalClubConfig 中一个个添加 sql 模板文件
2：免除在实际的模板文件中书写 namespace，以免让 sql 定义往后缩进一层
3：在此文件中还可以通过 define 指令定义一些通用模板函数，供全局共享
   例如定义通用的 CRUD 模板函数

#namespace("permission")
#include("permission.sql")
#end

#namespace("upgetpay")
#include("upgetpay.sql")
#end

#namespace("ready")
#include("ready.sql")
#end

#namespace("order")
#include("order.sql")
#end


#namespace("index")
#include("index.sql")
#end


#namespace("storage")
#include("storage.sql")
#end



#namespace("pay")
#include("pay.sql")
#end


#namespace("check")
#include("check.sql")
#end