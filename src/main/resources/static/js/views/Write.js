import Template from "./Template.js";

export class Write extends Template {
    constructor(params){
        super(params);
        this.setTitle("Detail");
    }

    async getHtml(){
        const form = document.querySelector("#post-form");

        const formData = new FormData();
        formData.append("title", form.title.value);
        formData.append("writer", form.writer.value);
        formData.append("description", form.writer.value);

        return `
         <form id="post-form" action="/posts" method="post"><br/>
            <input name="title" placeholder="제목"/><br/>
            <input name="writer" placeholder="글쓴이"/><br/>
            <textarea name="description"></textarea><br/>
            <button>글 작성!</button>
        </form>
        `;
    }
}