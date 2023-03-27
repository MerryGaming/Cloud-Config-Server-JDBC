1. What is Spring cloud config server
- Spring Cloud Config Server là một dịch vụ trong Spring Cloud cung cấp khả năng quản lý cấu hình trung tâm cho các ứng dụng. Nó cho phép ta lưu trữ cấu hình của ứng dụng ở một nơi trung tâm và các ứng dụng khác có thể truy cập vào nó để lấy thông tin cấu hình. 

![image](https://user-images.githubusercontent.com/103310499/227933891-a067417b-7c7a-4dd3-a989-5ce962171ad4.png)


2. Why use Spring cloud config server
- Trong một Project, ngoài mã (code) nó còn chứa các cấu hình, chẳng hạn như các thông tin kết nối vào cơ sở dữ liệu, thông tin vị trí các nguồn dữ liệu khác,...
- Rất không tốt khi ta sử dụng code cứng(hard code) trong project bởi nó có khá nhiều rủi ro và lỗi khác nhau
- Vì khi hoàn thành một project hoàn thành thì các tệp cấu hình kết hợp với code tạo thành một sản phẩm
- Nếu có một thay đổi nào đó trong cấu hình thì cần phải biên dịch lại, triển khai lại lên server.
- Nó khiến cho mất rất nhiều thời gian, nhân lực.
- Vậy nên chúng ta nên cấu hình nó trên một máy chủ độc lập. 

-Khi sử dụng Config Server, chúng ta có thể cập nhật cấu hình một cách dễ dàng và nhanh chóng. Các ứng dụng Client có thể truy cập vào Config Server để lấy thông tin cấu hình hoặc đăng ký để nhận thông báo khi thông tin cấu hình thay đổi.

- Spring Cloud Config Server hỗ trợ nhiều loại lưu trữ khác nhau như Git, Subversion, File system, JDBC. Nó cũng hỗ trợ mã hóa và giải mã các giá trị cấu hình để bảo mật thông tin cấu hình.

3. How can deploy spring cloud config save as JDBC
- Trước hết ta cần phải tạo một entity gồm các thuộc tính như sau:
![image](https://user-images.githubusercontent.com/103310499/227940283-2c8860c6-2fef-4eec-9d09-0f8e40b83dcd.png)


- Tạo thông tin thì nó vẫn tạo các thuộc tính như những gì chúng ta đã học

- Để có thể hiện thị thông tin của client đã được config với server ta sẽ phải tìm Client đó dựa trên Application, Profile, Label đã đăng ký với server:
![image](https://user-images.githubusercontent.com/103310499/227943186-1b683b3a-1018-469d-b905-231c50ff0e54.png)
![image](https://user-images.githubusercontent.com/103310499/227943227-b382f4df-9314-492f-bf79-1b94c7204062.png)


- Chúng ta sẽ phải tạo cách hiển thị thông tin và config đúng format như sau:
![image](https://user-images.githubusercontent.com/103310499/227947020-c3c7c5ce-0a7d-4b38-a62e-fadcc385f603.png)

- Để có thể cho nó hiển thị như vậy được ta sẽ thực hiện các bước như sau:

![image](https://user-images.githubusercontent.com/103310499/227947201-8dace47e-2078-4ab6-b159-5f54be6cdeb7.png)
- Ta sẽ lấy các config của Client dựa theo Application, Profile, Label.

![image](https://user-images.githubusercontent.com/103310499/227947473-86ec65fe-2bab-41b3-b6e1-e3fa79b6e076.png)
- Tiếp theo ta sẽ lấy một list các config với classpath nào  dựa theo Application, Profile, Label.

![image](https://user-images.githubusercontent.com/103310499/227947965-112bc7f9-2e69-4e32-9ba2-375187ed4d7a.png)
- Cuối cùng ta sẽ ghép chúng lại và có thể tạo ra một cách hiển thị config ở bên trên.


- Chúng ta không thể quên cách Config cho server này để khi mà phía Client gọi thì chúng ta có thể lấy thông tin ra cho phía Client bằng cách Config như sau.
![image](https://user-images.githubusercontent.com/103310499/227948336-1d6b011f-8e6c-4d8e-8f56-bd97de03daaf.png)
- Hiện tại mình đang làm theo phương pháp lưu theo JDBC vậy nên chúng ta đầu tiên sẽ phải config nó với phía Database
- Sau đó chúng ta sẽ có config với câu Query như trên để khi phía Client gọi tới server theo Application, Profile, Label thì server sẽ trả cho phía Client config mà họ đã lưu với server.

- Để phía Client có thể lấy được thông tin ở server, đầu tiên ta phải thêm dependency cho Client
![image](https://user-images.githubusercontent.com/103310499/227949026-3dd71c9f-9767-46f5-84e8-0ae2588f22d1.png)
![image](https://user-images.githubusercontent.com/103310499/227949113-5664390f-33d4-4d5a-9d3f-0259cf992f7a.png)

- Sau đó chúng ta sẽ config như sau:
![image](https://user-images.githubusercontent.com/103310499/227949233-2de62b5f-ba8a-4f10-8eb4-1ddfbf14bb1d.png)
