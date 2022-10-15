# ArchUnit Framework 研究

參加了 JCConf 2022後，研究此框架並試用其情境

###### 注意事項:
- 專案有Lombok，如要使用需要在 IDE 底下安裝 lombok.jar
- 專案無連接資料庫，只是示意情境使用
- Framework為Unit Test Framework，情境:<br>
  => `src/test/java/com.archUnit` Run Unit Test
  

###### 凍結規則:
- 第一次執行規則後，會將其存至plain text file，後續只會報告新的違規項目
- 凍結的設定檔: `src/test/java/resources/archUnit.properties`

# Reference:
- [ArchUnit](https://www.archunit.org/)
- [JCConf-ArchUnit Demo Project](https://github.com/shihyuho/jcconf2022-ArchUnit)