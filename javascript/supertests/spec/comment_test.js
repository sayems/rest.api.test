const should = require('chai').should();
import {expect, assert} from "chai";
import Adapter from "../lib/adapter";
const adapter = new Adapter();

describe('GET / Comments', () => {
    it('should return a 200 response', function (done) {
        this.timeout(50000);
        adapter.get('/comments?postId=1')
            .expect(200)
            .end((err, res) => {
                const result = JSON.parse(res.text);
                assert.equal(result[0].id, 1);
                done();
            });
    });
});