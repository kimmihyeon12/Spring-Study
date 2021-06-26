import Template from './Template.js';

export class Home extends Template {
    constructor(params){
        super(params);
        this.setTitle("Home");
    }

    async getHtml(){

        const posts = await fetch("/api/posts")
            .then(data=> data.json())
            .catch(err => {
                throw new Error(err);
            });

        console.log(posts);

        return `
        <h1>홈이에요~!</h1>
          <a href="/api-create" data-link>글 작성하기</a>
          <hr/>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>작성자</th>
                        <th>제목</th>
                        <th>내용</th>
                    </tr>
                </thead>
                <tbody>
                    
                        ${ posts.map( post => {
                           return "<tr><td>"+ post.id +"</td><td>"+ post.writer +"</td><td>"+ post.title +"</td><td>"+ post.desc +"</td></tr>";
                        }) }
                    
                </tbody>
            </table>
        `;
    }
} 