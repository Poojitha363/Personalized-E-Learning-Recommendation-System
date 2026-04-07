
from flask import Flask, jsonify
import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity

app = Flask(__name__)

data = [
    [1,101,5],[1,102,3],[2,101,4],[2,103,5],[3,104,5]
]
df = pd.DataFrame(data, columns=["userId","courseId","rating"])

def recommend(user_id):
    matrix = df.pivot_table(index='userId', columns='courseId', values='rating', fill_value=0)
    sim = cosine_similarity(matrix)
    sim_df = pd.DataFrame(sim, index=matrix.index, columns=matrix.index)
    users = sim_df[user_id].sort_values(ascending=False)[1:3]
    rec = set()
    for u in users.index:
        rec.update(matrix.loc[u][matrix.loc[u]>0].index.tolist())
    return list(rec)[:5]

@app.route("/recommend/<int:user_id>")
def rec(user_id):
    return jsonify(recommend(user_id))

if __name__ == "__main__":
    app.run()
